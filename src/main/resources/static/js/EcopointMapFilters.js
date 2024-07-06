export default class MapFilter {
    constructor(createMarkers) {
        this.createMarkers = createMarkers;
    }

    setupEventHandlers() {
        const self = this;

        $(document).on("click", "#clearFilters", function () {
            removeMarkers();
            $("#selectNeighborhood").val("").trigger("change");
            $("#selectResidue").val("").trigger("change")
        })

        // $(document).on("click", "#loadDefault", function () {
        //     removeMarkers();
        //     $("#selectNeighborhood").val("").trigger("change");
        //     $("#selectResidue").val("").trigger("change");
        // })

        $(document).on("change", "#mapHeader select", function (event) {
            removeMarkers();
            let neighborhood = $("#selectNeighborhood :selected").val();
            let residueId = $("#selectResidue :selected").val();

            $.get(`${window.location.pathname}/filtrar`, {
                neighborhood: neighborhood,
                residueId: residueId
            }, function (data) {
                if (data && data.length != 0) {
                    $(data).each((i, entry) => {
                        const coords = {
                            lat: +entry.latitude,
                            lng: +entry.longitude
                        };

                        self.createMarkers(coords, entry);
                    })
                }
            })
        });

        function removeMarkers() {
            MARKERS.slice(1).forEach(marker => {
                marker.map = null
            });
        }
    }
}