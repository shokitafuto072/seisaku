package ja.ac.ohara.oharabank.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ja.ac.ohara.oharabank.model.Oharabankhyou;


 
@Repository
public interface OharabankRepository  extends JpaRepository<Oharabankhyou, Long>{
 
}
 
 