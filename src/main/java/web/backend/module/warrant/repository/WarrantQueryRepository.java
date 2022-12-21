package web.backend.module.warrant.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonDataListDto;
import web.backend.module.common.repository.CommonQueryMethod;
import web.backend.module.company.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static web.backend.module.company.QCompany.company;
import static web.backend.module.file.QFile.file;
import static web.backend.module.warrant.QWarrant.warrant;

@Repository
@Slf4j
public class WarrantQueryRepository {
    private final JPAQueryFactory query;

    public WarrantQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<?> list(CommonDataListDto dataListDto) {

        CommonQueryMethod method = new CommonQueryMethod();

        List<Tuple> fetch = query.
                select(
                        Projections.fields(
                                WarrantListDto.class,
                                warrant.warrantIndex,
                                warrant.warrantCompanyCode,
                                warrant.warrantOwnerName,
                                warrant.warrantRegNumber,
                                warrant.warrantCompanyName,
                                warrant.warrantCompanyAddress,
                                warrant.warrantCompanyTel,
                                warrant.warrantEmail,
                                warrant.warrantSign,
                                warrant.warrantSignPad,
                                warrant.warrantStampImage,
                                warrant.warrantSignDate,
                                warrant.warrantSendDate,
                                warrant.warrantCompanyType,
                                warrant.warrantManageCode,
                                warrant.warrantLookupStatus,
                                warrant.warrantSpecialPeopleBoolean,
                                warrant.warrantSpecialPeoples,
                                warrant.warrantSpecialPeopleResult,
                                warrant.warrantRefundBoolean,
                                warrant.warrantRefundAmount,
                                warrant.warrantMainType,
                                warrant.warrantCompanyAddressDetail,
                                warrant.warrantRegNumber2,
                                warrant.warrantContents,
                                // 파일 이름
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileName)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("stamp")))
                                        , "warrantStampName"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileName)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("regcard")))
                                        , "warrantPersonalRegCardName"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileName)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("business")))
                                        , "warrantBusinessRegCardName"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileName)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("warrant_refund_complete")))
                                        , "warrantRefundCompleteName"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileName)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("warrant_complete")))
                                        , "warrantCompleteName"
                                ),
                                // 경로
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileLocation)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("stamp")))
                                        , "warrantStampPath"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileLocation)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("regcard")))
                                        , "warrantPersonalRegCardPath"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileLocation)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("business")))
                                        , "warrantBusinessRegCardPath"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileLocation)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("warrant_refund_complete")))
                                        , "warrantRefundCompletePath"
                                ),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(file.fileLocation)
                                                .from(file)
                                                .where(file.fileCustomerCode.eq(warrant.warrantCompanyCode).and(file.fileKinds.eq("warrant_complete")))
                                        , "warrantCompletePath"
                                )
                        ),company
                ).from(method.fromMethod(dataListDto))
                .leftJoin(company)
                .on(warrant.warrantManageCode.eq(company.companyCode))
                .where(
                        method.equalMethod(dataListDto),
                        method.betweenMethod(dataListDto),
                        method.likeMethod(dataListDto)
                )
                .orderBy(method.orderByMethod(dataListDto))
                .offset((long) dataListDto.getPageNumber() * dataListDto.getPostNumber())
                .limit(dataListDto.getPostNumber())
                .fetch();

        List<WarrantListDto> list = new ArrayList<>();
        for (int i = 0; i < fetch.size(); i++) {
            WarrantListDto warrantListDto = new WarrantListDto(fetch.get(i).get(0,WarrantListDto.class),fetch.get(i).get(1, Company.class));
            list.add(warrantListDto);
        }

        return list;
    }

}
