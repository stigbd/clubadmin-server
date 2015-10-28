/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("members")
@Indexes(
        @Index(value = "salary", fields = @Field("salary"))
)
public class Member {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;

    }
}
