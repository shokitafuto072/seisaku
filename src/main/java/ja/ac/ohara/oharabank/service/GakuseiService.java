package ja.ac.ohara.oharabank.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import ja.ac.ohara.oharabank.model.Oharabankhyou;
import ja.ac.ohara.oharabank.repository.OharabankRepository;
import jakarta.transaction.Transactional;

 
@Service
@Transactional
public class  GakuseiService{
 
    @Autowired
    private OharabankRepository repository;
 
    /**
     * 学生一覧の取得
     * @return List<Gakusei>
     */
    public List<Oharabankhyou> getGakuseiList() {
        List<Oharabankhyou> entityList = this.repository.findAll();
        return entityList;
    }
 
    /**
     * 詳細データの取得
     * @param @NonNull Long index
 
     */
    public Oharabankhyou get(@NonNull Long index) {
    	Oharabankhyou gakusei = this.repository.findById(index).orElse(new Oharabankhyou());
        return gakusei;
    }
 
    public void save(@NonNull Oharabankhyou gakusei) {
        this.repository.save(gakusei);
    }
 
    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.repository.deleteById(index);
    }
}