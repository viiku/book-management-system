package com.example.BookManagement.repository;

import com.example.BookManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //    JpaRepository: Provides built-in methods for CRUD operations (e.g., save, findById, delete).

    //    search by title
    List<Book> findByTitleContainingIgnoreCase(String title);
    //    search by author
    List<Book> findByAuthorContainingIgnoreCase(String author);
    //    search by price range
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);

    // Combined search (optional, if needed for complex queries)
    @Query("SELECT b FROM Book b WHERE " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))) AND " +
            "(:minPrice IS NULL OR :maxPrice IS NULL OR b.price BETWEEN :minPrice AND :maxPrice)")
    List<Book> searchBooks(@Param("title") String title,
                           @Param("author") String author,
                           @Param("minPrice") Double minPrice,
                           @Param("maxPrice") Double maxPrice);
}
