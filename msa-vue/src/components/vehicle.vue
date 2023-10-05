<script>
export default {
  name: "vehicle",
  props:{
    registration:String,
    brand:String,
    model:String,
    color:String,
    fiscalHp:Number,
    datePickup:Date,
    odometer:Number,
    dateReturn:Date,
    reservationPrice:Number,
    cleaningCost:Number,
    mileageCost:Number,
    type:String,
    displacement:Number,
    loadVolume:Number,
    lastTimingBeltMaintenanceOdometer:Number,
    lastChainMaintenanceOdometer:Number,
    lastChainMaintenanceDate:Date,
    lastSuspensionMaintenanceDate:Date,

  }
}
</script>

<template>
  <li>
    <h3><span style="font-size: small">{{brand}}</span> {{model}} <span style="font-size: small">{{color}}</span></h3>
    <p>{{fiscalHp}} chevaux!<span class="price"> {{reservationPrice}} Euro/jour</span></p>
  </li>

</template>

<style scoped>
li{
  list-style: none;
  margin: 10px 60px 10px 60px;
  border: solid #34495e 1px;
}
li:hover {
  transform: scale(1.3);
}
h3{
  display: flex;
  justify-content: space-around;
  color: #41b883;
}
h3 span{
  filter: saturate(0.3);
}
p{
  display: flex;
  justify-content: space-evenly;
}
</style>