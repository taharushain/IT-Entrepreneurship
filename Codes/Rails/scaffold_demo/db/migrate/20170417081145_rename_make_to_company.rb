class RenameMakeToCompany < ActiveRecord::Migration[5.0]
  def change
  	rename_column :cars, :make, :company
  end
end
