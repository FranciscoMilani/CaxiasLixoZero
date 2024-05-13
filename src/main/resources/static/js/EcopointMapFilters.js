$(document).ready(function() {
    $(document).on("click", "#clearFilters", function() {
        $("#selectNeighborhood").val(-1);
        $("#selectResidue").val(-1);
        removeMarkers();
    })

    $(document).on("change", "#mapHeader select", function() {
        let neighborhoodDes = $("#selectNeighborhood :selected").text();
        let residueType = $("#selectResidue :selected").val();

        $.get(`${window.location.pathname}/`, { residueType: residueType, neighborhoodDes: neighborhoodDes }, function (data) {
            // TODO: Carregar markers novos
            console.log(data)
        })
    });

    function removeMarkers() {
        MARKERS.forEach(marker => {
            marker.map = null
        });
    }
})

