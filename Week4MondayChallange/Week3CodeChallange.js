window.onload = function(){
    var bookShelf = [];
    
}
function showPopup(n) {
    var popup = document.getElementById("myPopup" + n);
    popup.classList.toggle("show");
  }
function createBook(title, auther, genre, coverImageURL){
    var book = {
        title: title,
        auther: auther,
        genre: genre,
        coverImageURL: coverImageURL
    }
    return book;
}
function injectContent(bookID){
    
}