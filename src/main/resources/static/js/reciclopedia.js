document.addEventListener("DOMContentLoaded", function() {
    function setupStandardSearch(searchBarId, listIds) {
        const searchBar = document.getElementById(searchBarId);
        const lists = listIds.map(id => document.getElementById(id)).filter(el => el !== null);
        const allItems = lists.flatMap(list => Array.from(list.getElementsByTagName('li')));

        const itemListMap = new Map();
        allItems.forEach(item => {
            itemListMap.set(item, item.parentNode);
        });

        searchBar.addEventListener('input', function() {
            const filter = searchBar.value.toLowerCase();
            if (filter === '') {
                redistributeItems(allItems, lists);
            } else {
                const filteredItems = filterItems(allItems, filter);
                redistributeItems(filteredItems, lists);
            }
        });

        function filterItems(items, filter) {
            return items.filter(item => {
                let text = item.textContent || item.innerText;
                return text.toLowerCase().indexOf(filter) > -1;
            });
        }

        function redistributeItems(items, lists) {
            lists.forEach(list => list.innerHTML = '');
            items.sort((a, b) => {
                const textA = a.textContent || a.innerText;
                const textB = b.textContent || b.innerText;
                return textA.localeCompare(textB);
            });

            let halfIndex = Math.ceil(items.length / 2);
            items.forEach((item, index) => {
                if (index < halfIndex) {
                    lists[0].appendChild(item);
                } else {
                    lists[1].appendChild(item);
                }
            });
        }

        redistributeItems(allItems, lists);
    }

    function setupRecyclableSearch(searchBarId, listIds) {
        const searchBar = document.getElementById(searchBarId);
        const lists = listIds.map(id => document.getElementById(id)).filter(el => el !== null);
        const allItems = lists.flatMap(list => Array.from(list.getElementsByTagName('li')));

        const itemListMap = new Map();
        allItems.forEach(item => {
            itemListMap.set(item, item.parentNode);
        });

        searchBar.addEventListener('input', function() {
            const filter = searchBar.value.toLowerCase();
            if (filter === '') {
                redistributeItems(allItems, lists);
            } else {
                const filteredItems = filterItems(allItems, filter);
                redistributeItems(filteredItems, lists);
            }
        });

        function filterItems(items, filter) {
            return items.filter(item => {
                let text = item.textContent || item.innerText;
                return text.toLowerCase().indexOf(filter) > -1;
            });
        }

        function redistributeItems(items, lists) {
            lists.forEach(list => list.innerHTML = '');
            items.sort((a, b) => {
                const textA = a.textContent || a.innerText;
                const textB = b.textContent || b.innerText;
                return textA.localeCompare(textB);
            });
            items.forEach(item => {
                const originalList = itemListMap.get(item);
                originalList.appendChild(item);
            });
        }

        redistributeItems(allItems, lists);
    }

    if (document.getElementById('residuoList1') || document.getElementById('especialList1') || document.getElementById('rejeitoList1')) {
        setupStandardSearch('searchBar', ['residuoList1', 'residuoList2', 'especialList1', 'especialList2', 'rejeitoList1', 'rejeitoList2']);
    }

    if (document.getElementById('plasticosList') || document.getElementById('papeisList') || document.getElementById('metaisList') || document.getElementById('vidrosList')) {
        setupRecyclableSearch('searchBarRecyclable', ['plasticosList', 'papeisList', 'metaisList', 'vidrosList']);
    }
});