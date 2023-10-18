
package dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Accessors(chain = true)
public class PetDTO {


    private CategoryDTO mCategory;

    private Long mId;

    private String mName;

    private List<String> mPhotoUrls;

    private String mStatus;

    private List<TagDTO> mTags;



}
