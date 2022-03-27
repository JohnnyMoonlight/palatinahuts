<template>
  <div style="width: 100%; height: 100%" id="map"></div>
</template>
<style scoped>
</style>
<script>
import "leaflet/dist/leaflet.css";

import L from "leaflet";
import geojson from "../data/palatinate_forest";

export default {
  name: "HutMap",
  props: [
    "latitude",
    "longitude",
    "zoomLevel",
    "markersForMap",
    "setPinOnClick",
    "huts",
  ],
  data: () => ({
    geojson: geojson,
    map: null,
    icon: null,
    marker: null,
    //
  }),
  methods: {
    emitEvent(e) {
      this.$emit("mapclicked", e.latlng);
    },
    addMarkerToMap(marker) {
      marker.addTo(this.map);
    },
  },
  created() {},
  watch: {
    huts: function (newVal, oldVal) {
      console.log("Prop changed: ", newVal, " | was: ", oldVal);
      for (let m of this.huts) {
        L.marker(
          { lat: m.latitude, lon: m.longitude },
          { icon: this.icon }
        ).addTo(this.map);
      }
    },
  },
  mounted() {
    this.icon = L.icon({
      iconUrl: require("/node_modules/leaflet/dist/images/marker-icon.png"),
      iconSize: [26, 40],
      iconAnchor: [13, 40],
    });
    this.map = L.map("map").setView(
      [this.latitude, this.longitude],
      this.zoomLevel
    );
    if (this.setPinOnClick == "true") {
      this.map.on("click", (e) => {
        this.emitEvent(e);
        if (this.marker) {
          this.map.removeLayer(this.marker);
        }
        this.marker = L.marker(e.latlng, { icon: this.icon });
        this.addMarkerToMap(this.marker);
      });
    }

    L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
      attribution:
        '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    }).addTo(this.map);
    L.geoJSON(geojson).addTo(this.map);
  },
};
</script>
