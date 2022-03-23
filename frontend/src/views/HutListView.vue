<template>
  <div>
    <v-container>
      <v-dialog
        v-model="dialog"
        hide-overlay
        transition="dialog-bottom-transition"
        max-width="600"
      >
        <template v-slot:activator="{}">
          <HutList v-on:detailHutAnnounced="showDetail($event)"> </HutList>
        </template>

        <template v-slot:default>
          <HutDetail
            @closeDetail="dialog = false"
            :detailHut="detailHut"
          ></HutDetail>
        </template>
      </v-dialog>
    </v-container>
  </div>
</template>

<script>
import HutDetail from "@/components/HutDetail.vue";
import HutList from "@/components/HutList.vue";

export default {
  name: "HutListView",
  components: {
    HutDetail,
    HutList,
  },
  methods: {
    showDetail: function (detail) {
      this.dialog = true;
      this.detailHut = detail;
    },
  },
  data: () => ({ dialog: false, detailHut: "" }),
};
</script>
