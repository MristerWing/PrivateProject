
function dfs(tag) {
    let nodeName = document.getElementsByTagName(tag);
    let nodeChild = nodeName.childNodes;

    for(let i = 0;i < nodeChild.length;i++) {
        if(nodeChild[i].nodeType == 1) {
            if(nodeChild[i].childNodes.length > 1) {
                dfs(nodeChild[i].childNodes.nodeName);
            }
        }
    }
}