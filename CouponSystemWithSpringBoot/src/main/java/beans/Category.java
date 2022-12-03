package beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public enum Category {
	Food(1, "food"), Electricity(2, "electricity"), Resturant(3, "resturant"), Vacation(4, "vacation");

	
	
	@Id
	@OneToMany(mappedBy ="categoryId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@Column(name="categotyID")
	private int id;
	private String name;

	private Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
