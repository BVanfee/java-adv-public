package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Issue {
    /*Egy hibabejelentő rendszer egy alkalmazással kapcsolatosan
    bejelentett hibákat tartalmazza.

Legyen egy issuetracker.Issue osztály, mely a rendszerben lévő
hibákat reprezentálja, egy name attribútummal, LocalDateTime time és
egy Status status attribútummal! A Status egy enum NEW, IN_PROGRESS és CLOSED értékekkel.

Legyen egy Comment osztály, amely tartalmazzon egy String text
és egy LocalDateTime time attribútumot! A megjegyzések copy konstruktorral legyenek másolhatóak!

Az Issue tartalmazzon egy Comment listát!

A Issue osztálynak is legyen egy copy konstruktora,
mely kap egy másik Issue példányt, valamint egy CopyMode
enum értéket! Ez vagy CopyMode.WITH_COMMENTS vagy CopyMode.WITHOUT_COMMENTS!
Előbbi esetben a megjegyzéseket is másolja, utóbbi esetben nem!
A megjegyzések másolásakor azoknak a copy konstruktora kerüljön meghívásra (deep copy)!*/

    private String name;
    private Status status;
    private LocalDateTime date;
    private List<Comment> comments = new ArrayList<>();


    public Issue(String name, LocalDateTime date, Status status) {
        this.name = name;
        this.status = status;
        this.date = date;

    }

    public Issue(Issue issue, CopyMode copyMode) {
        name = issue.name;
        status = issue.status;
        date = issue.date;
        if(copyMode.equals(CopyMode.WITH_COMMENTS)){
            comments = copyComments(issue);
        }
    }

    private List<Comment> copyComments(Issue issue) {
        List<Comment> copy = new ArrayList<>();
        for (Comment comment : issue.comments) {
            copy.add(new Comment(comment));
        }
        return copy;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
