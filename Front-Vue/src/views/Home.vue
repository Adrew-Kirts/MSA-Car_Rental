<script>

import { defineComponent, ref, reactive } from 'vue';
import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';

export default defineComponent({
  setup() {

    //added for login
    const formState = reactive({
      user: '',
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

  <button @click="showDrawer">Login</button>
  <a-drawer
      title="Existing user"
      placement="right"
      :closable="true"
      v-model:visible="visible"
      :after-visible-change="afterVisibleChange"
  >
    <p>Please login with your credentials</p>


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
        <a-button
            type="primary"
            html-type="submit"
            :disabled="formState.user === '' || formState.password === ''"
        >
          Log in
        </a-button>
      </a-form-item>
    </a-form>

  </a-drawer>


</template>



<style>

</style>