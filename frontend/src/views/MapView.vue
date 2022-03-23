<template>
  <div id="mapContainer">
    <HutMap
      v-on:mapClicked="console.log(e)"
      latitude="49.308592000000004"
      longitude=".892475186106314"
      zoomLevel="10"
    ></HutMap>
  </div>
</template>
<style>
#mapContainer {
  background-color: rgb(202, 202, 202);
  height: 100%;
  width: 100%;
}
.container {
  padding: 0px;
}
</style>
<script>
import HutMap from "../components/HutMap.vue";

export default {
  name: "HomeView",
  components: {
    HutMap,
  },
};
</script>
