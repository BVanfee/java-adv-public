package lambdaoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Club {
    /*Hozz létre egy Member osztályt, String name, List<String> skills,
    Gender gender attribútumokkal! A Gender legyen egy enum,
    MALE és FEMALE példányokkal!

Majd hozz létre egy Club osztályt, mely Member objektumokat képes tárolni!

A Optional<Member> findFirst(Predicate<Member> predicate) metódusa paraméterként egy keresési feltételt kap, visszatérési típusa Optional. Ha talál a keresési feltételnek megfelelő tagot, akkor az elsőt adja vissza, ha nem talál, üres értékkel tér vissza.

Az Optional<Double> averageNumberOfSkills() üres értékkel tér vissza, ha a klub nem tartalmaz tagot. Ellenkező esetben átlagolja a tagok szakértelmének számát, és azzal tér vissza.*/

    private List<Member> members;

    public Club(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> predicate){
        for (Member member : members) {
            if(predicate.test(member)){
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills(){
        int sumSkill = 0;
        if(members.isEmpty()){
            return Optional.empty();
        }else{
            for (Member member : members) {
                sumSkill += member.getSkills().size();
            }
            return Optional.of((double) sumSkill / members.size());
        }
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }
}
