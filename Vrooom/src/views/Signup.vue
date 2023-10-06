<script>
import CustomerService from "@/services/CustomerService";
import {useUserStore} from '@/stores/CustomerStore';

export default {
  data() {
    return {
      formData: {
        firstName: "",
        lastName: "",
        birthdate: "",
        licenseId: "",
        licenseDate: "",
      },
    };
  },
  methods: {
    async submitForm() {
      try {

        const formData = {...this.formData};
        formData.birthdate = formData.birthdate.format('YYYY-MM-DD')
        formData.licenseDate = formData.licenseDate.format('YYYY-MM-DD')
        const response = await CustomerService.postUser(formData);

        // Add the registered user to the Pinia store
        const userStore = useUserStore();
        userStore.addUser(formData);

        console.log("User registered:", response);

        // clear the form after submission
        this.formData = {
          firstName: "",
          lastName: "",
          birthdate: "",
          licenseId: "",
          licenseDate: "",
        };

      } catch (error) {
        console.error("Error registering user:", error);
      }
    },
  },
};
</script>

<template>

  <div class="signupBox">
    <p>Signup here !</p>

    <a-form>

      <a-form-item label="First name" name="firstName">
        <a-input v-model:value="formData.firstName"></a-input>
      </a-form-item>

      <a-form-item label="Last name" name="lastName">
        <a-input v-model:value="formData.lastName"></a-input>
      </a-form-item>

      <a-form-item label="Date of Birth" name="dateOfBirth">
        <a-date-picker v-model:value="formData.birthdate"></a-date-picker>
      </a-form-item>

      <a-form-item label="Drivers license ID" name="licenseId">
        <a-input v-model:value="formData.licenseId"></a-input>
      </a-form-item>

      <a-form-item label="Drivers license date issued" name="licenseDate">
        <a-date-picker v-model:value="formData.licenseDate"></a-date-picker>
      </a-form-item>

      <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
        <a-button @click="submitForm" html-type="submit">Submit</a-button>
      </a-form-item>

    </a-form>

  </div>
</template>

<style scoped>

.signupBox {
  background-color: rgba(255, 255, 255, 0.8);
  padding: 50px;
}

</style>

