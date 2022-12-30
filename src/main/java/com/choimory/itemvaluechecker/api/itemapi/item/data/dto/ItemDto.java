package com.choimory.itemvaluechecker.api.itemapi.item.data.dto;

import com.choimory.itemvaluechecker.api.itemapi.item.entity.*;
import com.choimory.itemvaluechecker.api.itemapi.member.entity.Member;
import com.choimory.itemvaluechecker.api.itemapi.member.entity.MemberAuthority;
import com.choimory.itemvaluechecker.api.itemapi.member.entity.MemberSocial;
import com.choimory.itemvaluechecker.api.itemapi.member.entity.MemberSuspension;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDto {
    private Long id;
    private String title;
    private String content;
    private String thumbnail;
    private Integer priceGoal;
    private MemberDto member;
    private CategoryDto category;
    private ItemHtmlDto itemHtml;
    private List<ItemImageDto> itemImages;
    private List<ItemPriceHistoryDto> itemPriceHistories;

    public static ItemDto toDto(Item item){
        return item == null
                ? null
                : ItemDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .content(item.getContent())
                .thumbnail(item.getThumbnail())
                .priceGoal(item.getPriceGoal())
                .member(MemberDto.toDto(item.getMember()))
                .category(CategoryDto.toDto(item.getCategory()))
                .itemHtml(ItemHtmlDto.toDto(item.getItemHtml()))
                .itemImages(item.getItemImages()
                        .stream()
                        .map(ItemImageDto::toDto)
                        .collect(Collectors.toUnmodifiableList()))
                .itemPriceHistories(item.getItemPriceHistories()
                        .stream()
                        .map(ItemPriceHistoryDto::toDto)
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MemberDto {
        private Long id;
        private String identity;
        private String nickname;
        private String email;

        public static MemberDto toDto(Member member){
            return member == null
                    ? null
                    : MemberDto.builder()
                    .id(member.getId())
                    .identity(member.getIdentity())
                    .nickname(member.getNickname())
                    .email(member.getEmail())
                    .build();
        }

        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        public static class MemberAuthorityDto {
            private Long id;
            private MemberAuthority.AuthLevel authLevel;

            public static MemberAuthorityDto toDto(MemberAuthority memberAuthority){
                return memberAuthority == null
                        ? null
                        : MemberAuthorityDto.builder()
                        .id(memberAuthority.getId())
                        .authLevel(memberAuthority.getAuthLevel())
                        .build();
            }
        }

        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        public static class MemberSocialDto {
            private Long id;
            private MemberSocial.SocialType socialType;
            private String socialId;

            public static MemberSocialDto toDto(MemberSocial memberSocial){
                return memberSocial == null
                        ? null
                        : MemberSocialDto.builder()
                        .id(memberSocial.getId())
                        .socialType(memberSocial.getSocialType())
                        .socialId(memberSocial.getSocialId())
                        .build();
            }
        }

        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        public static class MemberSuspensionDto {
            private Long id;
            private String reason;
            private LocalDateTime suspendedAt;
            private LocalDateTime suspendedTo;

            public static MemberSuspensionDto toDto(MemberSuspension memberSuspension){
                return memberSuspension == null
                        ? null
                        : MemberSuspensionDto.builder()
                        .id(memberSuspension.getId())
                        .reason(memberSuspension.getReason())
                        .suspendedAt(memberSuspension.getSuspendedAt())
                        .suspendedTo(memberSuspension.getSuspendedTo())
                        .build();
            }
        }
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ItemHtmlDto {
        private Long id;
        private String itemUrl;
        private String priceHtmlTag;

        public static ItemHtmlDto toDto(ItemHtml itemHtml){
            return itemHtml == null
                    ? null
                    : ItemHtmlDto.builder()
                    .id(itemHtml.getId())
                    .itemUrl(itemHtml.getItemUrl())
                    .priceHtmlTag(itemHtml.getPriceHtmlTag())
                    .build();
        }
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class CategoryDto {
        private Long id;
        private int depth;
        private String name;
        // TODO
//        private CategoryDto parent;
//        private List<CategoryDto> children;

        public static CategoryDto toDto(Category category){
            return category == null
                    ? null
                    : CategoryDto.builder()
                    .id(category.getId())
                    .depth(category.getDepth())
                    .name(category.getName())
                    .build();
        }
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ItemImageDto {
        private Long id;
        private String name;
        private String url;
        private String size;
        private String resizeName;
        private String resizeUrl;
        private String resizeSize;

        public static ItemImageDto toDto(ItemImage itemImage){
            return itemImage == null
                    ? null
                    : ItemImageDto.builder()
                    .id(itemImage.getId())
                    .name(itemImage.getName())
                    .url(itemImage.getUrl())
                    .size(itemImage.getSize())
                    .resizeName(itemImage.getResizeName())
                    .resizeUrl(itemImage.getResizeUrl())
                    .resizeSize(itemImage.getResizeSize())
                    .build();
        }
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ItemPriceHistoryDto {
        private Long id;
        private Integer price;

        public static ItemPriceHistoryDto toDto(ItemPriceHistory itemPriceHistory){
            return itemPriceHistory == null
                    ? null
                    : ItemPriceHistoryDto.builder()
                    .id(itemPriceHistory.getId())
                    .price(itemPriceHistory.getPrice())
                    .build();
        }
    }
}
