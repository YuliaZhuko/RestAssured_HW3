package dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetResponseDTO {
    private long id;
    private List<String> photoUrls;
    private List<TagDTO> tags;


}
