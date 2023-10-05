<script setup>
import QuickStart from "@/components/QuickStart.vue";
</script>

<template>
  <main>
    <div id="home">

      <div id="logo">
        <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="200" height="200" />
        <div id="vrooom">ROOOM</div>
      </div>

      <div id="quickStart">
        <QuickStart></QuickStart>
      </div>

    </div>
  </main>
</template>

<style scoped>
#home{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
}

#logo{

}

#vrooom{
  position: absolute;

}

#quickStart{
  margin: 50px;
}
</style>