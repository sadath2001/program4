package com.example.restful_demo;
//imports

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final List<Book> books = new ArrayList<Book>();

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return findBookById(id);
    }


    @PostMapping
    public Book addBook(@RequestBody Book book) {
        book.setId(generateBookId());
        books.add(book);
        return book;
    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book existingBook = findBookById(id);

        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPublicationYear(updatedBook.getPublicationYear());
        }
        return existingBook;
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        Book bookToRemove = findBookById(id);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }


    // Helper method to find a book by ID
    private Book findBookById(Long id) {
        for(Person p:al) {
		if(p.getName().equalsIgnoreCase(name)) {
			return p;
		}else {
			return null;
		}
	}
    }
}



