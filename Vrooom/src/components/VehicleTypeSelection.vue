<script>
import VehiclesService from "@/services/VehiclesService";
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
  }, methods: {
    lookAt(type) {
      console.log(type)
      this.$router.push({
        path: '/vehicles',
        query: {type: type}
      })
    },
    // getVehicles(){
    //   VehiclesService.getVehicles(this.$route.query)
    //       .then((response)=>this.Vehicles = response.data)
    // },
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
    <a-button type="link">All our Vehicles</a-button>

    <template #content>
      <a-form>
        <p>Select your vehicle type: </p>
        <a-form-item :wrapper-col="{ offset: 1, span: 20 }">
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link" @click="lookAt('car')">Car</a-button>
          <br>
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link" @click="lookAt('motorcycle')">Motorcycle</a-button>
          <br>
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link" @click="lookAt('utility')">Utility</a-button>
          <br>
          <img alt="logo" src="@/assets/logo.svg" style="width: 15px; height: 15px; transform: rotate(270deg);">
          <a-button type="link" @click="lookAt(null)">All</a-button>
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

.ant-btn {
  padding: 0 5px;
  font-size: 18px;
  color: black;
  font-family: Inter, sans-serif;
}

p {
  margin: 10px 10px 20px 10px;
  font-size: 18px;
  font-family: Inter, sans-serif;
}

</style>


