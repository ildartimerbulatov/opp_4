package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getChildren(String fullName) {
        List<T> children = new ArrayList<>();
        for (T member : members) {
            if (member.getParents().stream().anyMatch(p -> p.getFullName().equals(fullName))) {
                children.add(member);
            }
        }
        return children;
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Person::getFullName));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}






