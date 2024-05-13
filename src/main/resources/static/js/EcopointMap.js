$(document).ready(function () {
    let map;

    async function initMap() {

        const {InfoWindow, Map} = await google.maps.importLibrary("maps");
        const {AdvancedMarkerElement} = await google.maps.importLibrary("marker");
        const {Geocoder, GeocoderRequest} = await google.maps.importLibrary("geocoding")

        const MARKERS = [];

        window.MARKERS = MARKERS;

        const infoWindow = new InfoWindow({
            minWidth: 250,
            maxWidth: 500
        });

        handlePermission();

        async function getLatLngFromAddress(address) {
            return new Promise((resolve, reject) => {
                if (address) {
                    const rawAddress = `${address.street},  ${address.number} - ${address.neighborhood}`;
                    const mimeType = "json";
                    const encodedAddress = encodeURI(rawAddress);
                    const params = `${mimeType}?address=${encodedAddress}&key=${geoAPIKey}`;

                    if (encodedAddress && encodedAddress !== '') {
                        const geoUrl = `https://maps.googleapis.com/maps/api/geocode/${params}`;

                        $.get(geoUrl, (data) => {
                            if (data.status == "OK") {
                                let results = data.results[0];
                                resolve(results.geometry.location);
                            } else {
                                reject(data.status)
                            }
                        })
                        .fail(function () {
                            reject(null);
                        });
                    }
                }
            });
        }

        function populateInfoWindow(ecopoint) {
            const address = ecopoint.address;
            console.log(ecopoint)
            return `
                <div class="container d-flex flex-column">
                    <div>
                        <a href="tel:${ecopoint.phone}"><i class="bi bi-whatsapp"></i></a>
                        <a href="mailto:${ecopoint.email}"><i class="bi-envelope"></i></a>
                        <p class="text-center">${ecopoint.title}</p>
                    </div>
                    <div>
                        <p>Rua ${address.street}, nº ${address.number} - ${address.neighborhood}</p>
                        <p>Das <span>${ecopoint.openingDateTime}</span> h às <span>${ecopoint.closingDateTime}</span> h</p>
                    </div>
                    <div>
                        <ul>
                             ${(ecopoint.residues || [`<li>Qualquer resíduo</li>`]).map(residue => `<li>${residue}</li>`).join('')}
                        </ul>
                    </div>
                </div>
            `;
        }

        function createMarkers(mapCoords, ecopoint) {
            const markerImg = document.createElement("img");
            $(markerImg).attr({
                src: "/images/icons8-marker-blue-64.png",
                class: "eco-marker"
            });
            $("body").append(markerImg);

            const marker = new AdvancedMarkerElement({
                map: map,
                position: mapCoords,
                content: markerImg,
                title: ecopoint.title
            });

            marker.addListener("click", () => {
                infoWindow.setContent(populateInfoWindow(ecopoint));
                infoWindow.open(map, marker);
            });

            MARKERS.push(marker);
        }

        function handlePermission() {
            navigator.permissions.query({name: "geolocation"}).then((result) => {
                if (result.state === "granted") {
                    navigator.geolocation.getCurrentPosition(
                        (position) => loadMap(position.coords),
                        function (positionError) {
                            console.log(positionError)
                        },
                        {enableHighAccuracy: true}
                    );
                } else if (result.state === "prompt") {
                    navigator.geolocation.getCurrentPosition(
                        (position) => loadMap(position.coords),
                        function (positionError) {
                            console.log(positionError)
                        },
                        {enableHighAccuracy: true}
                    );
                } else if (result.state === "denied") {
                    console.log('denied')
                    // denied
                }
            });
        }

        function loadMap(userCoords) {
            const CAXIAS_ORIGIN = { lat: -29.166, lng: -51.174 };
            const USER_ORIGIN = { lat: userCoords.latitude, lng: userCoords.longitude };
            const ORIGIN = userCoords ? USER_ORIGIN : CAXIAS_ORIGIN;
            const ZOOM = 13;
            const MAX_ZOOM = ZOOM + 4;

            console.log(USER_ORIGIN)

            map = new Map(document.getElementById("map"), {
                center: ORIGIN,
                zoom: ZOOM,
                maxZoom: MAX_ZOOM,
                minZoom: ZOOM,
                mapId: "MAIN_ECP_MAP",
                mapTypeControl: false,
                streetViewControl: false,
                rotateControl: false,
                fullscreenControl: false,
            });

            $.get(window.location.href + "/listaecopontos")
                .done(function(data) {
                    $(data).each((i, entry) => {
                        getLatLngFromAddress(entry.address)
                            .then((coords) => {
                                createMarkers(coords, entry);
                            })
                            .catch((error) => {
                                console.error("Erro ao retornar localização do endereço:", error);
                            });
                    })
                })
                .fail(() => {
                    alert("Falha ao carregar ecopontos")
                })
        }
    }

    initMap();
});