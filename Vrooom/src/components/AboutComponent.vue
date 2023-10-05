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

      <!--      <a-form-->
      <!--          :model="formState"-->
      <!--          name="basic"-->
      <!--          :label-col="{ span: 8 }"-->
      <!--          :wrapper-col="{ span: 16 }"-->
      <!--          autocomplete="off"-->
      <!--      >-->
      <!--        <a-form-item-->
      <!--            label="Username"-->
      <!--            name="username"-->
      <!--            :rules="[{ required: true, message: 'Please input your username!' }]"-->
      <!--        >-->
      <!--          <a-input v-model:value="formState.username" />-->
      <!--        </a-form-item>-->

      <!--        <a-form-item-->
      <!--            label="Password"-->
      <!--            name="password"-->
      <!--            :rules="[{ required: true, message: 'Please input your password!' }]"-->
      <!--        >-->
      <!--          <a-input-password v-model:value="formState.password" />-->
      <!--        </a-form-item>-->

      <!--        <a-form-item name="remember" :wrapper-col="{ offset: 8, span: 16 }">-->
      <!--          <a-checkbox v-model:checked="formState.remember">Remember me</a-checkbox>-->
      <!--        </a-form-item>-->

      <!--        <a-form-item :wrapper-col="{ offset: 10, span: 16 }">-->
      <!--          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">-->
      <!--          <a-button type="link" html-type="submit">Login</a-button>-->
      <!--          <br>-->
      <!--          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">-->
      <!--          <a-button type="link">Create Account</a-button>-->
      <!--        </a-form-item>-->
      <!--      </a-form>-->


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


