<script>
export default {
  name: "Vehicle",
  props: {
    vehicle: Object
  }
}
</script>

<template>
  <a-card>
    <h3>{{vehicle.brand}} <span>{{vehicle.model}}</span> {{vehicle.reservationPrice}} $/day</h3>
  </a-card>
</template>

<style scoped>
.ant-card{
  width: 400px;
  font-weight: bolder;
}
h3{
  display: flex;
  justify-content: space-between;
}
h3 span{
  font-size: x-large;

}
</style>