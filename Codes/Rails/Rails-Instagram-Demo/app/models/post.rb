class Post < ApplicationRecord
  
  belongs_to :user  
  has_many :comments, dependent: :destroy
  # has_attached_file :image, styles: { :medium => "640x" }
  has_attached_file :image, default_url: "/images/:style/missing.png"
  validates_attachment_content_type :image, content_type: /\Aimage\/.*\z/
  validates :image, presence: true
  validates :user_id, presence: true

end
