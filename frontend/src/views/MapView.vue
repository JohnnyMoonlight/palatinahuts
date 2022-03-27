<template>
  <div id="mapContainer">
    <HutMap
      v-on:mapClicked="console.log(e)"
      latitude="49.308592000000004"
      longitude="7.892475186106314"
      zoomLevel="10"
      setPinOnClick="false"
      :huts="huts"
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
import API from "@/api/api";

export default {
  data: function () {
    return {
      huts: "",
    };
  },
  components: {
    HutMap,
  },
  methods: {},
  mounted() {
    API.getHuts().then((result) => (this.huts = result));
  },
};
</script>
