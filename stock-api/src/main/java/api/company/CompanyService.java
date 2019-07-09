package api.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {
  public Page<Company> getCompanies(Pageable pageable);

  public Company getCompanyById(Long companyId);

  public Company createCompany(Company company);

  public Company updateCompany(Long companyId, Company company);

  public void createCompanies(List<Company> company);

  public ResponseEntity<?> deleteCompany(Long companyId);
}