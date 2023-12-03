package hcmute.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayMethodModel{
	private String idPayMethod;
	private String name;
	private OrderModel orders;
}
