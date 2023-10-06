<script>

export default {
  data() {
    return {
      formState: {
        username: '',
        password: '',
        remember: true,
      },
      visible: false,
    }
  }
}

</script>

<template>

  <a-popover
      v-model:open="visible"
      trigger="hover"
      color="rgba(255, 255, 255, 0.8)"
      placement="bottom">

    <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px;">
    <a-button type="link">About</a-button>

    <template #content>

      <p class="ant-btn">Site created by:</p>
      <div class="photos">
        <img src="../assets/nico.png" height="180"/>
        <img src="../assets/ezra.png" height="180"/>
      </div>

      <router-link to="/about">About page</router-link>

    </template>

  </a-popover>

</template>

<style scoped>

.ant-dropdown-link {
  display: flex;
  flex: 0 0 auto;
}

.ant-btn {
  padding: 0 5px;
  font-size: 18px;
  color: black;
  font-family: Inter, sans-serif;
}

</style>


