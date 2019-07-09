package api.company;

import java.util.List;

import api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CompanyController implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    @Override
    public Page<Company> getCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() ->
                new ResourceNotFoundException("CompanyId " + companyId + " not found"));
    }

    @PostMapping("/companies")
    @Override
    public Company createCompany(@Valid @RequestBody Company companyRequest) {
        return companyRepository.save(companyRequest);
    }

    @PutMapping("/companies/{companyId}")
    @Override
    public Company updateCompany(@PathVariable Long companyId, @RequestBody Company companyRequest) {
        return companyRepository.findById(companyId).map(company -> {
            if (companyRequest.getCnpj() != null) {
                company.setCnpj(companyRequest.getCnpj());
            }

            if (companyRequest.getName() != null) {
                company.setName(companyRequest.getName());
            }

            if (companyRequest.getCompanyType() != null) {
                company.setCompanyType(companyRequest.getCompanyType());
            }

            return companyRepository.save(company);
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyId " + companyId + " not found"));
    }

    @Override
    public void createCompanies(@RequestBody List<Company> company) {

    }
    @DeleteMapping("/companies/{companyId}")
    @Override
    public ResponseEntity<?> deleteCompany(@PathVariable Long companyId) {
        return companyRepository.findById(companyId).map(company -> {
            companyRepository.delete(company);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyId " + companyId + " not found"));
    }
}