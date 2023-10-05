<script>

import LoginBox from "@/components/LoginBox.vue";

export default {
  components: {LoginBox},
  data() {
    return {
      open: false,
    }

  },
  methods: {
    showDrawer() {
      this.open = true
    }
  }
}

</script>

<template>
  <div class="logo-container">
    <img id="menu_button" alt="menu_logo" src="@/assets/logo.svg" :width="45" @click="showDrawer">
  </div>

  <div class="navbar">
    <a-drawer
        placement="top"
        :closable="false"
        :height="80"
        v-model:open="open">

      <div class="flex-container">
        <LoginBox></LoginBox>

        <router-link to="/vehicles" class="router-link">
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link">All our Vehicles</a-button>
        </router-link>

        <router-link to="/about" class="router-link">
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link">About</a-button>
        </router-link>
      </div>

    </a-drawer>
  </div>
</template>

<style scoped>

.flex-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
}

.router-link {
  text-align: center;
}

.ant-btn{
  padding: 0 5px;
  font-size: 18px;
  color: black;
  font-family: Inter,sans-serif;
}

.ant-drawer-body{
  padding: 13px;
}

.ant-drawer .ant-drawer-body{
  padding: 13px;
}

.ant-drawer{
  padding: 13px;
}

</style>
