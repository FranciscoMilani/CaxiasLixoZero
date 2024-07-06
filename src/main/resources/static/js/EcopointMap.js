import MapFilter from './EcopointMapFilters.js';

$(document).ready(function () {
    let map;

    async function initMap() {
        const {InfoWindow, Map} = await google.maps.importLibrary("maps");
        const {AdvancedMarkerElement} = await google.maps.importLibrary("marker");
        const {Geocoder, GeocoderRequest} = await google.maps.importLibrary("geocoding")
        const {PinElement} = await google.maps.importLibrary("marker");
        const MARKERS = [];
        const infoWindow = new InfoWindow({
            minWidth: 250,
            maxWidth: 500
        });

        window.MARKERS = MARKERS;
        handlePermission();

        function populateInfoWindow(ecopoint) {
            debugger
            const address = ecopoint.address;

            return `
                <div class="container d-flex flex-column">
                    <div>
                        <a href="tel:${ecopoint.phone}"><i class="bi bi-whatsapp"></i></a>
                        <a href="mailto:${ecopoint.email}"><i class="bi-envelope"></i></a>
                        <p class="text-center">${ecopoint.title}</p>
                    </div>
                    <div>
                        <p>Rua ${address.street}, nº ${address.number} - ${address.neighborhood}</p>
                        <p>Das <span>${ecopoint.openingTime}</span> h às <span>${ecopoint.closingTime}</span> h</p>
                    </div>
                    <div>
                        <ul>
                             ${(ecopoint.residues || [`<li>Qualquer resíduo</li>`]).map(residue => `<li>${residue.description}</li>`).join('')}
                        </ul>
                    </div>
                </div>
            `;
        }

        const createMarkers = function createMarkers(mapCoords, ecopoint) {
            const marker = new AdvancedMarkerElement({
                map: map,
                position: mapCoords,
                title: ecopoint.title,
                content: createMarkerElement(ecopoint.id)
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
                        (position) => {
                            const USER_COORDS = {
                                lat: position.coords.latitude,
                                lng: position.coords.longitude
                            };

                            loadMap(USER_COORDS);
                            createDefaultMarker(USER_COORDS);
                        },
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
                }
            });
        }

        function loadMap(userCoords) {
            const CAXIAS_ORIGIN = {lat: -29.166, lng: -51.174};
            //const ORIGIN = userCoords ? userCoords : CAXIAS_ORIGIN;
            const ORIGIN = CAXIAS_ORIGIN;
            const ZOOM = 13;
            const MAX_ZOOM = ZOOM + 4;

            var stylesArray = [
                {
                    featureType: '',
                    elementType: '',
                    stylers: [
                        {hue: ''},
                        {color: ''},
                        {visibility: ''},
                    ]
                },
                {
                    featureType: '',
                }
            ]

            map = new Map(document.getElementById("map"), {
                center: ORIGIN,
                zoom: ZOOM,
                maxZoom: MAX_ZOOM,
                minZoom: ZOOM,
                mapId: "29318c2a5b711652", // "MAIN_ECP_MAP"
                mapTypeControl: false,
                streetViewControl: false,
                rotateControl: false,
                fullscreenControl: false,
                clickableIcons: false,
            });

            // caso tenha vindo com residuo na url, não faz o retorno da lista de ecopontos inicial
            // e atualiza select para retornar apenas o que for selecionado
            if (window.RESIDUE_PRESELECT) {
                $("#mapHeader select").trigger("change");
                return;
            }

            $.get("mapa/listaecopontos") // window.location.href +
                .done(function (data) {
                    $(data).each((i, entry) => {
                        const coords = {
                            lat: +entry.latitude,
                            lng: +entry.longitude
                        };

                        createMarkers(coords, entry);
                    })
                })
                .fail((error) => {
                    alert("Falha ao carregar ecopontos: " + error)
                })
        }

        function createMarkerElement(id) {
            let element = document.createElement("img");

            $(element).attr({
                src: "/images/icons8-marker-blue-64.png",
                class: "eco-marker",
                "data-id": id
            });

            return new PinElement({
                background: "#FFFD55",
                borderColor: "#FFFD55",
                glyph: element
            }).element;
        }

        function createDefaultMarker(userCoords) {
            const element = document.createElement("img");

            $(element).attr({
                src: "/images/icons8-marker-green-64.png",
                class: "you-marker"
            });

            const marker = new AdvancedMarkerElement({
                map: map,
                position: userCoords,
                title: "Você",
                content: new PinElement({ glyph: element }).element
            });
            // `<div class="border rounded-2 bg-dark"><h3 class="text-light text-center justify-content-center">Você</h3></div>`
            MARKERS.push(marker);
        }

        const mapFilter = new MapFilter(createMarkers);
        mapFilter.setupEventHandlers();
    }

    initMap();
});