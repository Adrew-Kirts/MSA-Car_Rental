<script>

import { defineComponent, ref, reactive } from 'vue';
import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';

export default defineComponent({
  setup() {

    //added for login
    const formState = reactive({
      user: '',
      permit: '',
      age: "",
      password: '',});

    const handleFinish = values => {
      console.log(values, formState);
    };
    const handleFinishFailed = errors => {
      console.log(errors);
    };

    const visible = ref(false);
    const afterVisibleChange = bool => {
      console.log('visible', bool);
    };
    const showDrawer = () => {
      visible.value = true;
    };
    return {

//added
      formState,
      handleFinish,
      handleFinishFailed,

      visible,
      afterVisibleChange,
      showDrawer,
    };
  },

  //added
  components: {
    UserOutlined,
    LockOutlined,
  },

});


</script>


<template>


    <p>SIGNUP</p>


    <a-form
        layout="inline"
        :model="formState"
        @finish="handleFinish"
        @finishFailed="handleFinishFailed"
    >
      <a-form-item>
        <a-input v-model:value="formState.user" placeholder="Username">
          <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input v-model:value="formState.password" type="password" placeholder="Password">
          <template #prefix><LockOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
        </a-input>
      </a-form-item>

      <a-form-item>
        <a-input v-model:value="formState.age" placeholder="Age">
          <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
        </a-input>
      </a-form-item>

      <a-form-item>
        <a-input v-model:value="formState.permit" placeholder="Permit number">
          <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
        </a-input>
      </a-form-item>


      <a-form-item>
        <a-button
            type="primary"
            html-type="submit"
            :disabled="formState.user === '' || formState.password === ''"
        >
          Log in
        </a-button>
      </a-form-item>
    </a-form>



</template>



<style>

</style>