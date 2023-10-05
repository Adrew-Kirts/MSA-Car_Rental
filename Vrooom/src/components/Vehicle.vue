<script>
export default {
  name:"Vehicle",
  props:{
    vehicle:Object
  }
}
</script>

<template>
  <li>
    <h3>{{vehicle.brand}} {{vehicle.model}}</h3>
  </li>
</template>

<style scoped>

</style>