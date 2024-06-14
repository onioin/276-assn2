
function sortTable(byCol){
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchCount = 0;
    table = document.getElementById("rectTable");
    switching = true
    dir = 'A' // ascending sorting direction; use 'D' for descending

    while(switching){
        switching = false;
        rows = table.rows;
        console.log("witch")

        for(i = 1; i < (rows.length - 1); i++){
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("td")[byCol];
            y = rows[i+1].getElementsByTagName("td")[byCol];

            if(dir === 'A' && compareRows(x, y, byCol) > 0){
                shouldSwitch = true;
                break;
            }else if(dir === 'D' && compareRows(x, y, byCol) < 0){
                shouldSwitch = true;
                break;
            }
        }
        if(shouldSwitch){
            rows[i].parentNode.insertBefore(rows[i+1], rows[i]);
            switching = true;
            switchCount++;
        }else{
            if(switchCount === 0 && dir === 'A'){
                dir = 'D';
                switching = true;
            }
        }
    }
    drawArrow(byCol, dir);
}

function drawArrow(col, dir) {
    const table = document.getElementById("rectTable");
    let new_sort = table.rows[0].getElementsByTagName("th")[col];
    let old_sort = document.getElementById("sort");
    old_sort.innerHTML = old_sort.innerHTML.slice(0, -2);
    old_sort.id = null
    if(dir === 'A'){
        new_sort.innerHTML = new_sort.innerHTML + " &#8963;"
        new_sort.id = "sort"
    }else if(dir === 'D'){
        new_sort.innerHTML = new_sort.innerHTML + " &#8964;"
        new_sort.id = "sort"
    }
}

// Compares rows x and y depending on their data type
// Returns a positive value if x > y; 0 if x == y; a negative value if x < y
function compareRows(x, y, byCol){
    let d1, d2;
    switch(byCol){
        case 0:
            return x.innerHTML.localeCompare(y.innerHTML);
        case 1:
            return x.innerHTML.localeCompare(y.innerHTML);
        case 2:
            return (+x.innerHTML) - (+y.innerHTML);
        case 3:
            return (+x.innerHTML) - (+y.innerHTML);
        case 4:
            d1 = new Date(x.innerHTML);
            d2 = new Date(y.innerHTML);
            return d1 - d2;
        case 5:
            d1 = new Date(x.innerHTML);
            d2 = new Date(y.innerHTML);
            return d1 - d2;
        default:
            break;
    }
}

function rowClick(rect_id){
    location.href = "/rectangles/view/" + rect_id;
}
