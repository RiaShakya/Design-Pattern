package LibraryManagement.interfaces;

/*
 * ISP (Interface Segregation Principle)
 * This interface is only responsible for searching.
 */

public interface Searchable {

    void search(String keyword);

}