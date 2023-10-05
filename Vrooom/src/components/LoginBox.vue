<script>


export default {
  data(){
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


<!--  <a-dropdown>-->
<!--    <a class="ant-dropdown-link">-->
<!--      Login / Signup-->
<!--      <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px;">-->
<!--    </a>-->

  <a-popover
      v-model:visible="visible"
      title="Title"
      trigger="click"
      placement="bottomLeft">

    <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px;">
    <a-button type="link">Login / Signup</a-button>

    <template #content>
      <a-form
          :model="formState"
          name="basic"
          :label-col="{ span: 8 }"
          :wrapper-col="{ span: 16 }"
          autocomplete="off"
      >
        <a-form-item
            label="Username"
            name="username"
            :rules="[{ required: true, message: 'Please input your username!' }]"
        >
          <a-input v-model:value="formState.username" />
        </a-form-item>

        <a-form-item
            label="Password"
            name="password"
            :rules="[{ required: true, message: 'Please input your password!' }]"
        >
          <a-input-password v-model:value="formState.password" />
        </a-form-item>

        <a-form-item name="remember" :wrapper-col="{ offset: 8, span: 16 }">
          <a-checkbox v-model:checked="formState.remember">Remember me</a-checkbox>
        </a-form-item>

        <a-form-item :wrapper-col="{ offset: 10, span: 16 }">
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link" html-type="submit">Login</a-button>
          <br>
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link" html-type="submit">Create Account</a-button>
        </a-form-item>

      </a-form>
    </template>
  </a-popover>


</template>

<style scoped>

.ant-dropdown-link {
  display: flex;
  flex: 0 0 auto;
}

.ant-btn{
  padding: 0 5px;
  font-size: 18px;
  color: black;
  font-family: Inter,sans-serif;
}

</style>


