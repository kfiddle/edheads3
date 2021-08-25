//The openwindow function take a URL as a parameter and opens it in a new pop-up window
function openwindow(url) {
    newwindow=window.open(url,'name','height=600,width=600');
    if (window.focus) {newwindow.focus()}
    return false;
}
