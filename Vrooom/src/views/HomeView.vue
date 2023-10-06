<script setup>
import QuickStart from "@/components/QuickStart.vue";

</script>

<template>
  <main>

      <div id="logo">
        <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="200" height="200" />
        <div id="vrooom">ROOOM!!!</div>
      </div>

      <div id="quickStart">
        <QuickStart></QuickStart>
      </div>

  </main>
</template>

<style scoped>
main{
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
}



#logo{
  position:relative;
}

#vrooom{
  position: absolute;
  top: 30%;
  left: 60%;
  font-size: 60px;
  color: #2c3e50;
  font-weight: bold;
}

#quickStart{
  margin: 50px;
  background-color: rgba(0,0,0, .5) ;
  color: #2c3e50;

}
</style>