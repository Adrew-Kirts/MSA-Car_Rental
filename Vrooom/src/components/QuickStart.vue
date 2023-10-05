<script>
// import {VueIcon} from '@/assets/logo.svg'

export default {
  data(){
    return{
      type:null,
      date: null,
      vueIcon: '@/assets/logo.svg'
    }
  },
  methods:{
    submit(){
      this.$router.push({
        path:'/vehicles' ,
        query:{
          type:this.type ,
          startDate:this.date[0].format('YYYY-MM-DD') ,
          endDate:this.date[1].format('YYYY-MM-DD')
        }
      })
    }
  }
}

</script>

<template>

    <a-form id="quickstart">
      <a-select id="type" placeholder="Type" v-model:value="type" >
        <a-select-option value="car">Car</a-select-option>
        <a-select-option value="motorcycle">Motorcycle</a-select-option>
        <a-select-option value="utility">Utility</a-select-option>
      </a-select>
      <a-range-picker v-model:value="date"/>
      <a-icon @click="submit()">
        <img id="logoIcon" src="@/assets/logo.svg" width="25" height="25" alt="Quick start button"/>
      </a-icon>
    </a-form>

</template>

<style scoped>
.ant-select{
  width: 120px;
}
#quickstart{
  width: 800px;
  display: flex;
  justify-content: space-evenly;
  padding: 50px;
  border: solid 1px green ;
  border-radius: 10px;
}
#logoIcon{
  rotate: 270deg;
}
</style>