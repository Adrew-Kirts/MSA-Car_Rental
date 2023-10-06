<script>
import {useUserStore} from '@/stores/CustomerStore'

export default {
  computed: {
    currentUser() {
      const userStore = useUserStore();
      return userStore.users[0];
    },
  },
};
</script>

<template>
  <div class="box">
    <h1>Current registered user</h1>
    <template v-if="currentUser">
      <p>First Name: {{ currentUser.firstName }}</p>
      <p>Last Name: {{ currentUser.lastName }}</p>
      <p>Date of Birth: {{ currentUser.birthdate }}</p>
      <p>Driver's License ID: {{ currentUser.licenseId }}</p>
      <p>Driver's License Date Issued: {{ currentUser.licenseDate }}</p>
    </template>
    <template v-else>
      <p>No user registered yet.</p>
    </template>
  </div>
</template>


<style scoped>

.box {
  background-color: rgba(255, 255, 255, 0.8);
  padding: 50px;
}
</style>
