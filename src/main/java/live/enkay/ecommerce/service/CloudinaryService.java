package live.enkay.ecommerce.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudinaryService {
  private final Cloudinary cloudinary;

  public String uploadFile(MultipartFile file) throws IOException {
    return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url").toString();
  }

  public void deleteFile(String fileUrl) throws IOException {
    String publicId = fileUrl.substring(fileUrl.lastIndexOf("/") + 1, fileUrl.lastIndexOf("."));
    cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
  }
}
