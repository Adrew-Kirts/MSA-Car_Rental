<script>

import LoginBox from "@/components/LoginBox.vue";
import VehicleTypeSelection from "@/components/VehicleTypeSelection.vue";
import AboutComponent from "@/components/AboutComponent.vue";

export default {
  components: {AboutComponent, VehicleTypeSelection, LoginBox},
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

        <router-link to="/"><img alt="logo" src="@/assets/logo.svg" :width="50"></router-link>

        <LoginBox></LoginBox>

        <VehicleTypeSelection></VehicleTypeSelection>

        <AboutComponent></AboutComponent>

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

.a:hover{
  background-color: hsla(258.8, 79.3%, 47.5%, 0.2);
}

.logo-container {
  //display: flex;
  //justify-content: center;
  //align-items: flex-start;
  //height: 450px;
}


</style>
