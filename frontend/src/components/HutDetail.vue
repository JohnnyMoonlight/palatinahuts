<template>
  <v-card max-height="">
    <v-toolbar dense color="teal lighten-4"
      >{{ detailHut.name }} <v-spacer></v-spacer>
      {{ detailHut.association }}
      <v-btn icon><v-icon>mdi-pencil</v-icon> </v-btn
      ><v-btn icon @click="emitCloseDetail"
        ><v-icon>mdi-close</v-icon>
      </v-btn></v-toolbar
    >
    <v-divider class="mx-4"></v-divider>

    <v-card-text id="detailIcons">
      <div class="my-4 text-subtitle-1">
        <v-icon>mdi-cup-outline</v-icon>Rieslingschorle (€/0.5L):
        {{ detailHut.price }}
      </div>
      <div class="my-4 text-subtitle-1">
        <v-icon>mdi-diameter</v-icon>Leberknödel (mm):
        {{ detailHut.diameter }}
      </div>
      <div class="my-4 text-subtitle-1">
        <v-icon>mdi-slide</v-icon>Spielplatz:
        {{ detailHut.diameter }}
      </div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-carousel :continuous="true">
      <v-carousel-item
        v-for="(item, i) in detailHut.images"
        :key="i"
        :src="item.downloadPath"
        reverse-transition="fade-transition"
        transition="fade-transition"
      ></v-carousel-item>
    </v-carousel>
  </v-card>
</template>
<style scoped>
#detailIcons {
  text-align: left;
}
</style>
<script>
export default {
  name: "HutDetail",
  props: ["detailHut"],
  data: () => ({}),
  methods: {
    emitCloseDetail: function () {
      this.$emit("closeDetail");
    },
  },
  mounted() {},
};
</script>
