export default class MapFilter {
    constructor(createMarkers) {
        this.createMarkers = createMarkers;
    }

    setupEventHandlers() {
        const self = this;

        $(document).on("click", "#clearFilters", function () {
            $("#selectNeighborhood").val(-1);
            $("#selectResidue").val(-1);
            removeMarkers();
        })

        $(document).on("change", "#mapHeader select", function (event) {
            let neighborhoodDes = $("#selectNeighborhood :selected").text();
            let residueType = $("#selectResidue :selected").val();

            $.get(`${window.location.pathname}/`, {
                residueType: residueType,
                neighborhoodDes: neighborhoodDes
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
            MARKERS.forEach(marker => {
                marker.map = null
            });
        }
    }
}