<script>
export default {
  name:"Vehicle",
  props:{
    Vehicle:Object
  }
}
</script>

<template>
  <li>
    <h3>{{Vehicle.brand}} {{Vehicle.model}}</h3>
  </li>
</template>

<style scoped>

</style>