
function sortTable(byCol){
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchCount = 0;
    table = document.getElementById("rectTable");
    switching = true
    dir = 'A' // ascending sorting direction; use 'D' for descending

    while(switching){
        switching = false;
        rows = table.rows;

        for(i = 1; i < (rows.length - 1); i++){
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("td")[byCol];
            y = rows[i+1].getElementsByTagName("td")[byCol];

            if(dir === 'A' && x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()){
                shouldSwitch = true;
                break;
            }else if(dir === 'D' && x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()){
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
}

