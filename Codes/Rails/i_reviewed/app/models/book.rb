class Book < ApplicationRecord
  belongs_to :reviewer
  has_many :notes, dependent: :destroy
end
