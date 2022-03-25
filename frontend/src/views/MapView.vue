<template>
  <div id="mapContainer">
    <HutMap
      v-on:mapClicked="console.log(e)"
      latitude="49.308592000000004"
      longitude="7.892475186106314"
      zoomLevel="10"
      setPinOnClick="false"
      :markersForMap="huts"
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
      huts: [],
    };
  },
  components: {
    HutMap,
  },
  methods: {
    async getHuts() {
      API.getHuts().then((result) => (this.huts = result));
    },
  },
  mounted() {
    this.getHuts();
    console.log(this.huts);
  },
};
</script>
